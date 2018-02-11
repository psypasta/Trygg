#include <iostream>
#include <string>

using namespace std;

string flip(int, int);
string sideways(int);
string lineMake(int);
string spaceMake(int, int);

int main(){

	cout << sideways(25);
	return 0;
}

string sideways(int size){
	string sideTri;

	int i = 1;
	bool swap = false;
	while(true){
		if(i == size){
			swap = true;
		}else if(i == 0){
			break;
		}

		sideTri += (lineMake(i) + spaceMake(i, size) + lineMake(i) + flip(i, size) + '\n');

		if(!swap){
			i++;
		}else{
			i--;
		}
	}


	return sideTri;
}

string spaceMake(int index, int size){
	string s;
	char message = ' ';
	int amount = size-index;
	for(int i = 0; i < amount; i++){
		s += message;
	}
	return s;
}

string flip(int index, int size){
	string s;
	char message = '#';
	int amount = size-index;
	for(int i = 0; i < amount; i++){
		s += message;
	}
	return s;
}

string lineMake(int size){
	string s;
	char message = '#';

	for(int i = 0; i < size; i++){
		s += message;
	}

	return s;
}