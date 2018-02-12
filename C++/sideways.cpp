#include <iostream>
#include <string>
#include <vector>

using namespace std;

string flip(int, int);
string sideways(int);
string lineMake(int);
string spaceMake(int, int);

int main(){

	string quad = sideways(5);

	int lineCount = 1;
	int charCount = 1;
	for(char& c : quad) {
	    if(c=='\n'){
	    	lineCount++;
	    }
	    charCount++;
	}

	vector<string> lineVector = {}; 

	int tempLine = 0;
	for(int i = 0; i < charCount; i++){
		string temp = "";

		if(quad[i]=='\n'){
			for(; tempLine < i; tempLine++){
				temp += quad[tempLine];
			}
			lineVector.push_back(temp);
			tempLine++;
		}
	}

    for(string n : lineVector) {
        std::cout << n << '\n';
	}

	cout << charCount << endl;
	cout << lineCount << endl;

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
		sideTri += (spaceMake(i, size) + lineMake(i) + lineMake(i) + spaceMake(i, size) + '\n');
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