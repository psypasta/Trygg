#include <iostream>
#include <string>
#include <vector>
#include <unistd.h>

using namespace std;

vector<string> triToVec(int);
vector<string> quadToVec(int);
string lineMake(int);
string spaceMake(int, int);

int main(){

//	while(true){

		for(int i = 0; i < 1; i++){
			vector<string> v;
			v = quadToVec(15);

			vector<string> triVec;
			triVec = triToVec(20);

		    for(string n : v) {
		    //	n = n + n;
		        cout << n << '\n';
			}  

			for(string n : triVec) {
		    //	n = n + n;
		        cout << n << '\n';
			}
		}
/*		unsigned int microseconds = 6000;
		usleep(microseconds);

		printf("\033c");
	}
*/
	return 0;
}

vector<string> triToVec(int size){
	vector<string> tri;
	
	for(int i = size; i > size-size; i--){
		tri.push_back(spaceMake(i, size) + lineMake(i) + lineMake(i) + spaceMake(i, size));
	}

	return tri;
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