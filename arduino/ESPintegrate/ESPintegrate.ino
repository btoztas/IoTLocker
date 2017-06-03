/*
 *  This test will print to a PHP script the content on String say
 *  The URL for the PHP script is: 193.136.128.24/~ist179069/RMSF/get.php
 *  You can see the result on: 193.136.128.24/~ist179069/RMSF/left.html
 *
 *  The sequence of AT commands is the following:
 *
 *  AT+CWJAP_CUR="GONCALVES","abrunheira123"
 *  AT+CIPSTART="TCP","web.ist.utl.pt",80
 *  AT+CIPSEND=170
 *  POST /ist179069/RMSF/get.php HTTP/1.1
 *  Host: web.ist.utl.pt
 *  User-Agent: ESP8266
 *  Content-Length: 15
 *  Content-Type: application/x-www-form-urlencoded
 *
 *  word=IMACOMMENT
 */


#include <SPI.h>
#include <MFRC522.h>

#define SS_PIN 10
#define RST_PIN 9
MFRC522 mfrc522(SS_PIN, RST_PIN);   // Create MFRC522 instance.

#define RED_PIN 6
#define GREEN_PIN 7
#define YELLOW_PIN 8

#define BUZZ 3
#define BUTTON 4

char receivedserial[200];
const int switchPin = 2;
const int CH_PD = 5;
int flag;
int alerta1;



void send_ESP(String command) {

  //Serial.print("\r\n\n******* ENVIADO *******\r\n"+command+"\r\n***********************\r\n\n");

  Serial.print(command);
  Serial.print("\r\n");
  delay(100);

}
void send_ESP_NoDelay(String command) {

  //Serial.print("\r\n\n******* ENVIADO *******\r\n"+command+"\r\n***********************\r\n\n");

  Serial.print(command);
  Serial.print("\r\n");

}

void setup_ESP(){

  Serial.begin(115200);
  
  pinMode(CH_PD, OUTPUT);

  digitalWrite(CH_PD, LOW);
  delay(1000);
  digitalWrite(CH_PD, HIGH);
  delay(2500);

  send_ESP("AT+RST");

}

void connect_AP(String ap, String password){

  String command = "AT+CWJAP_CUR=\""+ap+"\",\""+password+"\"";
  send_ESP(command);
  
  Serial.setTimeout(10000);
  if(Serial.find("OK")){
    delay(1000);
  }else{
    connect_AP(ap, password);
  }

}

void disconnect_AP(){

  String command = "AT+CWQAP";
  send_ESP(command);
  delay(5000);

}

void tcp_CONNECT(String serv, int port){
  
  Serial.setTimeout(6000);
  Serial.flush();
  String command = "AT+CIPSTART=\"TCP\",\""+serv+"\","+port;
  send_ESP(command);
  Serial.flush();
  if(Serial.find("OK")){
    delay(500);
  }else if(Serial.find("")){
    delay(3000);
  }else{
    tcp_CONNECT(serv, port);
  }

}

void tcp_DISCONNECT(){

  Serial.flush();
  String command = "AT+CIPCLOSE";
  send_ESP(command);
  delay(100);

}

void tcp_POST(String message, String dir, String host){
  Serial.flush();
  String total = "POST "+dir+" HTTP/1.1\r\nHost: "+host+"\r\nUser-Agent: ESP8266\r\nContent-Length: "+(String)message.length()+"\r\nContent-Type: application/x-www-form-urlencoded\r\n\r\n"+message+"\r\n";
  String post[6];
  post[0] = "POST "+dir+" HTTP/1.1";
  post[1] = "Host: "+host;
  post[2] = "User-Agent: ESP8266";
  post[3] = "Content-Length: "+(String)message.length();
  post[4] = "Content-Type: application/x-www-form-urlencoded\r\n";
  post[5] = message + "\r\n";
  String command = "AT+CIPSEND="+(String)total.length();
  send_ESP(command);
  for(int i=0; i<5; i++){
    send_ESP(post[i]);
  }
  send_ESP_NoDelay(post[5]);
}

void tcp_GET(String url, String host){
  
  String total = "GET "+url+" HTTP/1.1\r\nHost: "+host+"\r\nUser-Agent: ESP8266\r\n\r\n";
  String gte[3];
  gte[0] = "GET "+url+" HTTP/1.1";
  gte[1] = "Host: "+host;
  gte[2] = "User-Agent: ESP8266\r\n";

  String command = "AT+CIPSEND="+(String)total.length();
  send_ESP(command);
  for(int i=0; i<3; i++){
    send_ESP(gte[i]);
  }
  delay(2500);
}

int status_ESP(){

  send_ESP("AT+CIPSTATUS");

}



void setup() {

  setup_ESP();
  
  pinMode(switchPin, INPUT);
  pinMode(RED_PIN, OUTPUT);
  pinMode(GREEN_PIN, OUTPUT);
  pinMode(YELLOW_PIN, OUTPUT);
  pinMode(BUZZ, OUTPUT);
  pinMode(BUZZ, INPUT);

  SPI.begin();      // Initiate  SPI bus
  digitalWrite(RED_PIN, HIGH);
  digitalWrite(GREEN_PIN, HIGH);
  digitalWrite(YELLOW_PIN, HIGH);

  Serial.setTimeout(4000);
  digitalWrite(switchPin, HIGH);
  digitalWrite(RED_PIN, LOW);
  digitalWrite(GREEN_PIN, LOW);
  digitalWrite(YELLOW_PIN, LOW);
  setup_ESP();
   digitalWrite(RED_PIN, HIGH);
  digitalWrite(GREEN_PIN, HIGH);
  digitalWrite(YELLOW_PIN, HIGH);
  connect_AP("RAINBOW", "123456789");
  digitalWrite(RED_PIN, LOW);
  digitalWrite(GREEN_PIN, LOW);
  digitalWrite(YELLOW_PIN, LOW);

  /*tcp_CONNECT("web.ist.utl.pt", 80);

  tcp_POST("word=<h1>BENFICA VAI GANHAR</h1>", "/ist179069/IoTLocker/arduino_test/get.php", "web.ist.utl.pt");
  */
  /*disconnect_AP();*/
  
  
}

void loop() {

  //IDLE STATE
  digitalWrite(RED_PIN, LOW);
  digitalWrite(GREEN_PIN, LOW);
  digitalWrite(YELLOW_PIN, LOW);
  int card_detected=0;
  int currentTime, elapsedTime;
  int cleared=0;
  int waitresp_time;
  int i;
  mfrc522.PCD_Init();   // Initiate MFRC522

  if(digitalRead(BUTTON)){
    digitalWrite(YELLOW_PIN, HIGH);
    for(i=1;i<15;i++){
      tone(BUZZ, 1000);
      delay(200);
      noTone(BUZZ);
      delay(1000/(2*i));
      tone(BUZZ, 1000);
      delay(200);
      noTone(BUZZ);
      delay(1000/(2*i));
      tone(BUZZ, 1000);
      delay(200);
      noTone(BUZZ);
      delay(1000/(2*i));
      tone(BUZZ, 1000);
      delay(200);
      noTone(BUZZ);
      delay(1000/(2*i));
    }
    tone(BUZZ, 1000);
    delay(1000);
    noTone(BUZZ);
    digitalWrite(YELLOW_PIN, LOW);
  }

  
  if(digitalRead(switchPin) == HIGH){
    digitalWrite(RED_PIN, LOW);
    digitalWrite(GREEN_PIN, LOW);
    digitalWrite(YELLOW_PIN, HIGH);
    elapsedTime = currentTime = millis();    
       

    while(currentTime-elapsedTime<30000){
      tone(BUZZ, 1000);
      delay(200);
      noTone(BUZZ);
      delay(200); 
      flag=0;
      currentTime = millis();
      
      if (!mfrc522.PICC_IsNewCardPresent()){
        flag=1;
      }
      if (!mfrc522.PICC_ReadCardSerial()){
        flag=1;
      }
      
      if(flag==0){
          String content= "";
          byte letter;
          
          for (byte i = 0; i < mfrc522.uid.size; i++){
             //content.concat(String(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " "));
             content.concat(String(mfrc522.uid.uidByte[i], HEX));
          }
          
          content.toUpperCase();
          
          String tosend= "id=" + content;
          tcp_CONNECT("193.136.128.24", 80);
          tcp_POST(tosend, "/ist179069/IoTLocker/add_checkin.php", "web.tecnico.ulisboa.pt");
          
          Serial.setTimeout(10000);
          Serial.find("ACCESS");
          
          Serial.setTimeout(500);
          if(Serial.find("DENIED")){
            tcp_DISCONNECT();
            digitalWrite(YELLOW_PIN, LOW);
            digitalWrite(RED_PIN, HIGH);
            tone(BUZZ, 500);
            delay(5000);
            noTone(BUZZ);
            
                   
          }else{
            tcp_DISCONNECT();
            digitalWrite(YELLOW_PIN, LOW);
            digitalWrite(GREEN_PIN, HIGH);
            tone(BUZZ, 2500);
            delay(350);
            noTone(BUZZ);            
            delay(300);
            tone(BUZZ, 2500);
            delay(350);
            noTone(BUZZ);
            delay(300);
            tone(BUZZ, 2500);
            delay(350);
            noTone(BUZZ);
          }
          
          break;
      }
    }
    
    if(flag==1){
      
      // DOOR OPENED, NO AUTHENTICATION
      tcp_CONNECT("193.136.128.24", 80);
      tcp_POST("id=2", "/ist179069/IoTLocker/add_alert.php", "web.tecnico.ulisboa.pt");
      tcp_DISCONNECT();
      digitalWrite(YELLOW_PIN, LOW);
      digitalWrite(RED_PIN, HIGH);
      tone(BUZZ, 500);
      delay(5000);
      noTone(BUZZ);
      
    }
  }
}
