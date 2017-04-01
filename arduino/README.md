# Ligações ao Arduino
## Modo ESPcomm (comunicação via Serial)
| Arduino 1     | ESP8266       | Arduino 2  |
| ------------- | ------------- | ---------- |
| TX            | TX            | TX         |
| RX            | RX            | -          |
| DIG 5         | CH_PD         | -          |
| 3v3           | VCC           | -          |
| GND           | GND           | -          |

## Modo ESPsimple (comunicação via Arduino)
| Arduino 1     | ESP8266       | Arduino 2  |
| ------------- | ------------- | ---------- |
| RX            | TX            | -          |
| TX            | RX            | TX         |
| DIG 5         | CH_PD         | -          |
| 3v3           | VCC           | -          |
| GND           | GND           | -          |


![alt-text](http://blog.filipeflop.com/wp-content/uploads/2015/06/ESP8266-Pinos.png)
