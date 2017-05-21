int switchPin = 2;
void setup() {
   Serial.begin(115200);
  pinMode(switchPin, INPUT);
  digitalWrite(switchPin,HIGH);
}

void loop() {

  if(digitalRead(switchPin)==HIGH)
    Serial.println("CLOSED!");
  else
    Serial.println("OPEN!");
  delay(500);

}
