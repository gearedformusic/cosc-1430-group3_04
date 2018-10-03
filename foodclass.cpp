// ConsoleApplication4.cpp : Defines the entry point for the console application.
//

/*3.1 Create a class named Food
This class will have the following properties:
- A private member of type float called volume
- A protected member of type int called calories
- A protected member of type bool called vegetarian
- A default constructor that sets the volume to 0, the calories to 0 and vegetarian to true.
- A constructor that takes a volume, calories and vegetarian as parameters.

- A copy constructor.
- Public accessors and mutators for volume, calories and vegetarian.
- The class overloads the operator ==

- A function called printItem() printing the a description of the class in the following
format
I am a vegetarian Food, my volume is 0.05 fl. Oz and I have 100
calories
Or
I am not​ a vegetarian Food, my volume is 0.05 fl. Oz and I have
100 calories
3*/
#include "stdafx.h"
#include <iostream>
using namespace std;



class Food {
private:
	float volume;
	
protected:
	int calories;
	bool vegetarian;
public:
	Food();
	Food(float vol, int cal, bool veg);

	//Copy
	Food(const Food &yum);

	//Operator Overload
	bool operator==(Food yum);

	//Mutators
	void SetVolume(float vol) { volume = vol; }
	void SetCalories(int cal) { calories = cal; }
	void SetVegetarian(bool veg) { vegetarian = veg; }

	//Accessors
	void PrintVolume() { cout << volume << " fl. Oz"; }
	void PrintCalories() { cout << calories << " calories"; }
	void PrintVegetarian();
	void printItem();
};

Food::Food() {
	volume = 0;
	calories = 0;
	vegetarian = true;
}

Food::Food(float vol, int cal, bool veg) {
	volume = vol;
	calories = cal;
	vegetarian = veg;
}

Food::Food(const Food &yum) {
	volume = yum.volume;
	calories = yum.calories;
	vegetarian = yum.vegetarian;
}

bool Food::operator==(Food yum) {
	return ((yum.volume == volume) && (yum.calories == calories) && (yum.vegetarian == vegetarian));
}

void Food::PrintVegetarian() {
	if (!vegetarian)
		cout << " not";
}
void Food::printItem() {
	cout << "I am";
	PrintVegetarian();
	cout << " a vegetarian Food, my volume is ";
	PrintVolume();
	cout << " and I have ";
	PrintCalories();
	cout << endl;
}



int main()
{
	/*//Test bench
	Food fd1 = Food(1, 200, true);
	Food fd2 = Food(fd1);
	fd1.printItem();
	if(fd1 == fd2)
	fd1.printItem();
	*/
	
}

