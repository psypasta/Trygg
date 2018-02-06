#include <iostream>
#include <string>

using namespace std;

string sideways(int);
string lineMake(int);

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

		sideTri += (lineMake(i) + '\n');

		if(!swap){
			i++;
		}else{
			i--;
		}
	}


	return sideTri;
}

string lineMake(int size){
	string s;
	char message = '#';

	for(int i = 0; i < size; i++){
		s += message;
	}

	return s;
}