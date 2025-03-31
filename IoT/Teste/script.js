// Configuração do Firebase
const firebaseConfig = {
    apiKey: "AIzaSyBHKUZ0Zk740pDCFDtWG73CYOttDErarck",
    authDomain: "esp32-firebase-server.firebaseapp.com",
    databaseURL: "https://esp32-firebase-server-default-rtdb.firebaseio.com",
    projectId: "esp32-firebase-server",
    storageBucket: "esp32-firebase-server.firebasestorage.app",
    messagingSenderId: "339523323265",
    appId: "1:339523323265:web:0a7e18b20ff4a798595480"
};

// Inicializa o Firebase
firebase.initializeApp(firebaseConfig);
const database = firebase.database();

const ledStatusElement = document.getElementById("ledStatus");
const toggleSwitch = document.getElementById("toggleSwitch");

// Atualiza o status do LED em tempo real
database.ref("led/state").on("value", (snapshot) => {
    const estado = snapshot.val();
    if (estado === 1) {
        ledStatusElement.textContent = "Ligado";
        toggleSwitch.classList.add("on");
    } else {
        ledStatusElement.textContent = "Desligado";
        toggleSwitch.classList.remove("on");
    }
});

// Alterna o estado do LED ao clicar no interruptor
toggleSwitch.addEventListener("click", () => {
    database.ref("led/state").once("value").then((snapshot) => {
        const estadoAtual = snapshot.val();
        const novoEstado = (estadoAtual === 1) ? 0 : 1;
        database.ref("led").set({ state: novoEstado });
    });
});

