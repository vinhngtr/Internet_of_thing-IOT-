package com.example.demoiot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {
    MQTTHelper mqttHelper;
    TextView txtTemp, txtHumi;
    ToggleButton btnTemp, btnHudmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTemp = findViewById(R.id.tempera);
        txtHumi = findViewById(R.id.humidity);
        btnTemp = findViewById(R.id.sw_temp);
        btnHudmi = findViewById(R.id.sw_hudmi);
        CompoundButton.OnCheckedChangeListener listener =
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b == true){
                            sendDataMQTT("vinhtrong782002/feeds/nutnhan1","1");
                        }else{
                            sendDataMQTT("vinhtrong782002/feeds/nutnhan1","0");
                        }
                    }
                };

        btnTemp.setOnCheckedChangeListener(listener);
        btnHudmi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true){
                    sendDataMQTT("vinhtrong782002/feeds/nutnhan2","1");
                }else{
                    sendDataMQTT("vinhtrong782002/feeds/nutnhan2","0");
                }
            }
        });
        startMQTT();
    }

    public void sendDataMQTT(String topic, String value){
        MqttMessage msg = new MqttMessage();
        msg.setId(1234);
        msg.setQos(0);
        msg.setRetained(false);

        byte[] b = value.getBytes(Charset.forName("UTF-8"));
        msg.setPayload(b);

        try {
            mqttHelper.mqttAndroidClient.publish(topic, msg);
        }catch (MqttException e){
        }
    }
    public void startMQTT(){
        mqttHelper = new MQTTHelper(this);
        mqttHelper.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean reconnect, String serverURI) {

            }

            @Override
            public void connectionLost(Throwable cause) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                Log.d("TEST", topic + "***" + message.toString());
                if(topic.contains("sensor-iot1")){
                    txtTemp.setText(message.toString() + "°C");
                }else if(topic.contains("sensor-iot2")){
                    txtHumi.setText(message.toString() + "%");
                }else if(topic.contains("nutnhan1")){
                    if(message.toString().equals("1")){
                        btnTemp.setChecked(true);
                    }else{
                        btnTemp.setChecked(false);
                    }
                }else if(topic.contains("nutnhan2")){
                    if(message.toString().equals("1")){
                        btnHudmi.setChecked(true);
                    }else{
                        btnHudmi.setChecked(false);
                    }
                }
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {

            }
        });
    }
}