#include <iostream>
#include <string>

using namespace std;

string* printTri(int);
string* printRect(int);
string messageString(int, int);
string halfLine(int);
string spaces(int, int);

int main(){

	int charSize = 25;

	string *triOne =		printTri(charSize);
	string *rectOne =		printRect(charSize);

	string halfTri[charSize];

	for(int i = 0; i < charSize; i++){
			halfTri[i] += rectOne[i];
			halfTri[i] += triOne[i];
			halfTri[i] += rectOne[i];
			halfTri[i] += "\n";
	}

	for(int i = 0; i < charSize; i++){
		cout << halfTri[i];
	}

	return 0;
}

string* printTri(int triangleSize){
	string *messageArray = new string[triangleSize];

	for(int i = 0; i < triangleSize; i++){
		messageArray[i]+=messageString(i, triangleSize);
	}

	for(int i = 0; i < triangleSize; i++){
		cout << messageArray[i] << endl;
	}

	return messageArray;
}

string* printRect(int charSize){
	string *messageArray = new string[charSize];

	for(int i = 0; i < charSize; i++){
		messageArray[i] += halfLine(charSize);
		messageArray[i] += halfLine(charSize);
	}

	for(int i = 0; i < charSize; i++){
		cout << messageArray[i] << endl;
	}

	return messageArray;
}

string messageString(int lineIndex, int triangleSize){
	
	int size = triangleSize;

	char message = '#';

	string s;

	if(lineIndex==0){
		s+=halfLine(size-lineIndex);
		s+=halfLine(size-lineIndex);
	}
	else if(lineIndex > 0 && lineIndex < (size-1)){
		s+=halfLine(size-lineIndex);
		s+=spaces(size-lineIndex, lineIndex);
	}
	else if(lineIndex==(size-1)){
		s+=halfLine(size);
		s+=halfLine(size);
	}
	return s;
}

string halfLine(int messageSize){
	string s = "";
	for(int i = 0; i < messageSize; i++){
		s += '#';
	}
	return s;
}

string spaces(int size, int messageSize){
	string s = "";
		for(int i = 0; i < (messageSize*2); i++){
			s += ' ';
		}
	s+=halfLine(size);
	return s;
}