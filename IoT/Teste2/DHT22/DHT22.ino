#include <WiFi.h>
#include <Firebase_ESP_Client.h>
#include "DHTesp.h"

#define WIFI_SSID "A21s"
#define WIFI_PASSWORD "12345678"

#define API_KEY "AIzaSyBrnqehQ_h9MbIcYlDHK4BHbyvgztQZRqs"

#define DATABASE_URL "https://iot-senai-esp32-default-rtdb.firebaseio.com" 

/* 4. Define the user Email and password that alreadey registerd or added in your project */
#define USER_EMAIL "conta.qualquer@email.com"
#define USER_PASSWORD "415263senha"


// Define Firebase Data object
FirebaseData fbdo;
FirebaseAuth auth;
FirebaseConfig config;

unsigned long sendDataPrevMillis = 0;
const int DHT_PIN = 4;
const int ledPin = 2;
DHTesp dhtSensor;

void setup()
{
  Serial.begin(115200);
  dhtSensor.setup(DHT_PIN, DHTesp::DHT22);

  pinMode(ledPin, OUTPUT);
  digitalWrite(ledPin, LOW);

  Serial.begin(115200);
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);

  Serial.print("Connecting to Wi-Fi");
  while (WiFi.status() != WL_CONNECTED)
  {
    Serial.print(".");
    delay(300);
  }
  Serial.println();
  Serial.print("Connected with IP: ");
  Serial.println(WiFi.localIP());
  Serial.println();

  /* Assign the api key (required) */
  config.api_key = API_KEY;
  /* Assign the user sign in credentials */
  auth.user.email = USER_EMAIL;
  auth.user.password = USER_PASSWORD;
  /* Assign the RTDB URL (required) */
  config.database_url = DATABASE_URL;
  // Comment or pass false value when WiFi reconnection will control by your code or third party library e.g. WiFiManager
  Firebase.reconnectNetwork(true);
  // Since v4.4.x, BearSSL engine was used, the SSL buffer need to be set.
  // Large data transmission may require larger RX buffer, otherwise connection issue or data read time out can be occurred.
  fbdo.setBSSLBufferSize(4096 /* Rx buffer size in bytes from 512 - 16384 */, 1024 /* Tx buffer size in bytes from 512 - 16384 */);
  // Limit the size of response payload to be collected in FirebaseData
  fbdo.setResponseSize(2048);


  Firebase.begin(&config, &auth);
  Firebase.setDoubleDigits(4);
  config.timeout.serverResponse = 10 * 1000;
}

void loop()
{
  TempAndHumidity  data = dhtSensor.getTempAndHumidity();
  // Firebase.ready() should be called repeatedly to handle authentication tasks.
  if (Firebase.ready() && (millis() - sendDataPrevMillis > 1000 || sendDataPrevMillis == 0))
  {
    sendDataPrevMillis = millis();

    if (Firebase.RTDB.setFloat(&fbdo, "/Var/temperatura", data.temperature)) {
      Serial.println("Temperatura enviada para o Firebase: " + String(data.temperature, 2) + "°C");
   }else{
      Serial.println("Erro ao enviar temperatura: ");
   }

    if (Firebase.RTDB.setFloat(&fbdo, "/Var/humidade", data.humidity)) {
      Serial.println("Umidade enviada para o Firebase: " + String(data.humidity, 1) + "%");
  } else {
      Serial.println("Erro ao enviar umidade: ");
  }

  int ledState;
   if(Firebase.RTDB.getInt(&fbdo, "/Led/state", &ledState)){
    digitalWrite(ledPin, ledState);
   }else{
    Serial.println("Error");
   }
  }
  delay(2000);
}