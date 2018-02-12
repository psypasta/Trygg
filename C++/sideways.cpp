#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<string> quadToVec(int);
string lineMake(int);
string spaceMake(int, int);

int main(){

	for(int i = 0; i < 5; i++){
		vector<string> v;
		v = quadToVec(10);

	    for(string n : v) {
	    	n += n + n;
	        cout << n << '\n';
		}
	}
	return 0;
}

vector<string> quadToVec(int size){
	vector<string> sideTri;
	int i = 1;
	bool swap = false;
	while(true){
		if(i == size){
			swap = true;
		}else if(i == 0){
			break;
		}

		sideTri.push_back(spaceMake(i, size) + lineMake(i) + lineMake(i) + spaceMake(i, size));
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

string spaceMake(int index, int size){
	string s;
	char message = ' ';

	for(int i = 0; i < size-index; i++){
		s+=message;
	}

	return s;
}

/*
string flip(int index, int size){
	string s;
	char message = '#';
	int amount = size-index;
	for(int i = 0; i < amount; i++){
		s += message;
	}
	return s;
}
*/