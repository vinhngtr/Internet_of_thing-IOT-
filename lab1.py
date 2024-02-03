import sys
from Adafruit_IO import MQTTClient
import random
import time

AIO_FEED_IDs = ["nutnhan1"]
AIO_USERNAME = "vinhtrong782002"
AIO_KEY = "aio_ChWq13Nvkgv7Kdj0e93nEdgbXe2f"

def connected(client):
    print("Ket noi thanh cong ...")
    for topic in AIO_FEED_IDs:
        client.subscribe(topic)

def subscribe(client , userdata , mid , granted_qos):
    print("Subscribe thanh cong ...")

def disconnected(client):
    print("Ngat ket noi ...")
    sys.exit (1)

def message(client , feed_id , payload):
    print("Nhan du lieu: " + payload)

client = MQTTClient(AIO_USERNAME , AIO_KEY)
client.on_connect = connected
client.on_disconnect = disconnected
client.on_message = message
client.on_subscribe = subscribe
client.connect()
client.loop_background()

while True:
    client.publish("nutnhan1", random.randint(0, 1))
    time.sleep(5)
    pass