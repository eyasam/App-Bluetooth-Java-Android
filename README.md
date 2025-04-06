# Fonctionnalité Bluetooth (Connexion P2P)

## 🎯 Objectif

Mettre en place la communication entre deux smartphones Android via Bluetooth classique, afin de permettre un futur lancement de jeu multijoueur synchronisé.

---

## ✅ Fonctionnalités développées

### 🔹 1. Découverte Bluetooth
- Utilisation du `BluetoothAdapter` pour démarrer un scan classique.
- Les appareils détectés sont affichés dynamiquement dans une `ListView`.
- Filtrage par adresse MAC pour éviter les doublons.
- Gestion des permissions (`BLUETOOTH_SCAN`, `ACCESS_FINE_LOCATION`, etc.) pour compatibilité Android 12+.

### 🔹 2. Connexion Bluetooth
- Création d’un `BluetoothClientThread` : initie une connexion RFCOMM à un appareil sélectionné.
- Création d’un `BluetoothServerThread` : écoute les connexions entrantes.
- Utilisation d’un UUID fixe partagé pour établir la connexion.

### 🔹 3. Synchronisation entre appareils
- Après connexion, le client envoie le message `"READY"`.
- Le serveur lit le message, et si `"READY"` est reçu :
  - Lancement de `DefiActivity` (activité de défi) sur les deux appareils.

### 🔹 4. Interface utilisateur
- `ListView` dynamique listant les appareils détectés.
- Deux boutons :
  - **Démarrer Scan**
  - **Arrêter Scan**
- Toasts informatifs, logs clairs via `Log.d/e`.

---

## 📁 Fichiers implémentés

### 📦 Java

- `MainActivity.java`  
  → Gère le scan Bluetooth, l'affichage des appareils, la connexion client et le lancement du serveur.

- `BluetoothClientThread.java`  
  → Thread pour établir une connexion vers un appareil distant. Envoie "READY".

- `BluetoothServerThread.java`  
  → Thread côté serveur. Attend une connexion entrante, lit "READY", et lance l'activité de défi.

- `DefiActivity.java`  
  → Activité affichée une fois la connexion établie. Affiche un texte simple "Défi 1 - Prêt ?"

---

### 🖼️ Layouts XML

- `activity_main.xml`  
  - 2 boutons : `startScanButton`, `stopScanButton`  
  - 1 `ListView` pour afficher les appareils Bluetooth détectés

- `activity_defi.xml`  
  - 1 `TextView` centré avec l’ID `defiText`

---

### 📄 AndroidManifest.xml

```xml
<uses-permission android:name="android.permission.BLUETOOTH" />
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.BLUETOOTH_SCAN" />
<uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />
<uses-permission android:name="android.permission.BLUETOOTH_ADVERTISE" />
```
