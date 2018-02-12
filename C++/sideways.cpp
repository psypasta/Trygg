#include <iostream>
#include <string>

using namespace std;

string flip(int, int);
string sideways(int);
string lineMake(int);
string spaceMake(int, int);

int main(){

	cout << sideways(5);
	
	cout << sideways(5);

	cout << sideways(5);

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


		//sideTri += (spaceMake(i, size) + lineMake(i) + lineMake(i) + '\n');
		sideTri += (spaceMake(i, size) + lineMake(i) + lineMake(i) + '\n');
		if(!swap){
			i++;
		}else{
			i--;
		}
	}


	return sideTri;
}

/*string spaceMake(int index, int size){
	string s;
	char message = ' ';
	int amount = size-index;
	for(int i = 0; i < amount; i++){
		s += message;
	}
	return s;
}*/

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

string spaceMake(int index, int size){
	string s;
	char message = ' ';

	for(int i = 0; i < size-index; i++){
		s+=message;
	}

	return s;
}