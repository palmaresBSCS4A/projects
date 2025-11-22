import subprocess
import time

# Path to the Arduino IDE and the sketch
arduino_exe = "C:/Program Files (x86)/Arduino/arduino_debug.exe"  # Path to Arduino IDE executable
sketch = "C:/Users/admin/Documents/Arduino/test_servo/test_servo.ino"  # Path to Arduino sketch

# Function to upload the sketch to Arduino
def upload_sketch():
    command = [arduino_exe, "--upload", sketch]
    subprocess.run(command)

# Function to send commands to Arduino via serial monitor
def send_command(angle):
    command = [arduino_exe, "--port", "COM3", "--upload", sketch, "--", str(angle)]
    subprocess.run(command)

try:
    upload_sketch()  # Upload the sketch to Arduino

    # Send commands to Arduino
    angles = [0, 90, 180]
    for angle in angles:
        send_command(angle)
        print("Sending angle:", angle)
        time.sleep(2)  # Wait for the servo to reach the desired position

except KeyboardInterrupt:
    print("\nTest interrupted")
