import serial
import time

# Open serial port to communicate with Arduino
ser = serial.Serial('COM7', 9600)  # Adjust port and baud rate as needed

# Read date and time from text file
with open(r'C:\Users\admin\Downloads\arduinonetbeansdraft\ScheduledSmartLockSystem\ScheduledSmartLockSystem\src\schedule.txt') as file:
    datetime_str = file.readline().strip()  # Assuming date and time are in the first line
    # Extract date and time information (format should match Arduino's expectations)
    print(datetime_str)

    datetime_values = datetime_str.split()  # Split datetime values
    move_datetime_str = datetime_values[0]  # First datetime value
    return_datetime_str = datetime_values[1]  # Second datetime value

# Combine move and return date and time into a single string
datetime_combined_str = move_datetime_str + " " + return_datetime_str

# Send combined date and time to Arduino
ser.write(datetime_combined_str.encode() + b'\n')  # Send combined date and time

ser.close()  # Close serial port
