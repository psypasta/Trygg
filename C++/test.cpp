#include <iostream>
#include <string>

using namespace std;

void printTri(int);
string messageString(int, int);
string halfLine(int);
string spaces(int, int);

int main(){

	printTri(5);

	return 0;
}

void printTri(int triangleSize){



	string messageArray[triangleSize];
	for(int i = 0; i < triangleSize; i++){
		messageArray[i]+=messageString(i, triangleSize);
	}

	for(int i = 0; i < triangleSize; i++){
		cout << messageArray[i] << endl;
	}
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