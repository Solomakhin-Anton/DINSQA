# Test plan of the application

1. Positive tests (fill in English in both fields - users and contacts):

- check the ability to send new data by POST;
- check the possibility of replacing data by PUT;
- check the ability to delete data by DELETE;
- check all recorded data by GET;

2. Negative tests:

a) Users:
- check the behavior of the program when sending empty data;
- check the behavior of the program if we send an empty value to the name;
- check the behavior of the program if we send an empty value of the last name;
- check the behavior of the program if we try to delete a nonexistent user;
- check the behavior of the program, if you try to replace the data with empty (PUT);
- check the behavior of the program, if you try to replace the data with new ones without entering a name;
- check the behavior of the program, if you try to replace the data with new ones without entering the last name;
- check the behavior of the program, if you enter the data in Russian;
- check the behavior of the program if we introduce characters instead of letters;
- check the behavior of the program if we replace the data with new ones using Russian letters;
- check the behavior of the program if we replace the data with new ones using the characters;
- check the behavior of the program if we enter name values ​​greater than 25 characters, for example, 26;
- check the behavior of the program if we enter last name values ​​greater than 25 characters, for example, 26;

b) Contacts: 
- check the behavior of the program when sending empty data;
- check the behavior of the program if we send an empty value to the name;
- check the behavior of the program if we send an empty value of the last name;
- check the behavior of the program if we try to delete a nonexistent user;
- check the behavior of the program, if you try to replace the data with empty (PUT);
- check the behavior of the program, if you try to replace the data with new ones without entering a name;
- check the behavior of the program, if you try to replace the data with new ones without entering the last name;
- check the behavior of the program, if you enter the data in Russian;
- check the behavior of the program if we introduce characters instead of letters;
- check the behavior of the program if we replace the data with new ones using Russian letters;
- check the behavior of the program if we replace the data with new ones using the characters;
- check the behavior of the program if we enter name values ​​greater than 25 characters, for example, 26;
- check the behavior of the program if we enter last name values ​​greater than 25 characters, for example, 26;
- check the behavior of the program if we enter the characters in the phone field;
- check the behavior of the program if we enter the letters in the phone field;
- check the behavior of the program if we enter one digit in the telephone field;
- check the behavior of the program if we enter twenty digits in the telephone field;
- check the behavior of the program if we enter a value without @ in the email field;
- check the behavior of the program if we enter Russian letters in the email field;
- check the behavior of the program if we enter only characters in the email field;
- check the behavior of the program if we enter only letters in the email field;
- check the behavior of the program if we leave the email field empty;
- check the behavior of the program if we leave the phone field empty;
