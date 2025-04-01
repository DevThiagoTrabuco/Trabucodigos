#include <WiFi.h>
#include <Firebase_ESP_Client.h>
#include "DHT.h"

#define WIFI_SSID "Wokwi-GUEST"
#define WIFI_PASSWORD ""

#define API_KEY "AIzaSyBrnqehQ_h9MbIcYlDHK4BHbyvgztQZRqs"
#define DATABASE_URL "https://iot-senai-esp32-default-rtdb.firebaseio.com"
#define USER_EMAIL "conta.qualquer@email.com"
#define USER_PASSWORD "415263senha"

#define ledPin 2
#define DHTPIN 4
#define DHTTYPE DHT22

DHT dht(DHTPIN, DHTTYPE);
FirebaseData fbdo;
FirebaseAuth auth;
FirebaseConfig config;

void setup() {
  pinMode(ledPin, OUTPUT);
  Serial.begin(115200);
  dht.begin();

  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting to Wi-Fi");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(300);
  }
  Serial.println();
  Serial.print("Connected with IP: ");
  Serial.println(WiFi.localIP());
  Serial.println();

  config.api_key = API_KEY;
  auth.user.email = USER_EMAIL;
  auth.user.password = USER_PASSWORD;
  config.database_url = DATABASE_URL;
  Firebase.reconnectNetwork(true);
  fbdo.setBSSLBufferSize(4096, 1024);
  fbdo.setResponseSize(2048);

  Firebase.begin(&config, &auth);
  Firebase.setDoubleDigits(4);
  config.timeout.serverResponse = 10 * 1000;
}

void loop() {
  delay(2000);
  float h = dht.readHumidity();
  float t = dht.readTemperature();

  if (isnan(h) || isnan(t)) {
    Serial.println(F("Failed to read from DHT sensor!"));
    return;
  }

  Serial.print(F("Humidity: "));
  Serial.print(h);
  Serial.print(F("%  Temperature: "));
  Serial.print(t);
  Serial.print(F("°C "));
  Serial.println("");


  if (Firebase.ready()) {
    Firebase.RTDB.setFloat(&fbdo, "/status/temperature", t);
    Firebase.RTDB.setFloat(&fbdo, "/status/humidity", h);

    bool ledStatus;
    if (Firebase.RTDB.getBool(&fbdo, "/status/led", &ledStatus)) {
      if (fbdo.dataType() == "boolean") {
        digitalWrite(ledPin, ledStatus ? HIGH : LOW);
        Serial.print("LED ");
        Serial.println(ledStatus ? "ON" : "OFF");
      } else {
        Serial.println("The data at /status/led is not a boolean.");
      }
    }
  }
}
