#include<iostream>
using namespace std;
class Food{

   float volume;
protected:
   int calories;
   bool vegetarian;
public:
   //mutators
   float getVol(){return volume;};
   int getCal(){return calories;};
   bool getVeg(){return vegetarian;};
  
   //accessors
   void setVol(float vol){volume = vol;};
   void setcal(int cal){calories = cal;};
   void setVeg(bool veg){vegetarian = veg;};
  
   bool operator == ( Food const&Food_2);
   void printItem();   
  
   Food(){volume =0;   //default constructor
   calories = 0;
   vegetarian =true;
   };
   Food(float vol_con,int cal_con,bool veg_con){ //parameteriezed constructor
       volume = vol_con;
       calories = cal_con;
       vegetarian = veg_con;
   };
   Food(const Food &a)
   {
       volume = a.volume;
       calories = a.calories;
       vegetarian = a.vegetarian;
   };
};

bool Food::operator==(Food const&Food_2)
{
   if(vegetarian == Food_2.vegetarian && calories==Food_2.calories && volume==Food_2.volume)
   return true;
   else
   return false;
}

void Food::printItem()
{
   if(vegetarian)
   {
       cout<<"I am a vegetarian Food, my volume is "<<volume<<" fl. Oz and I have "<<calories<<"calories";
   }
   else
   {
       cout<<"I am not a vegetarian Food, my volume is "<<volume<<" fl. Oz and I have "<<calories<<" calories";
   }
}


class CandyWrapper{

   float length,width;
   string color;
public:
   CandyWrapper(){length = 0.0;width=0.0;color="NA";};
   CandyWrapper(float len,float wid,string col){length = len; width=wid; color = col;};
   CandyWrapper(CandyWrapper const &Old){length = Old.length; width=Old.width; color = Old.color;};
   //mutators
   void SetLen(float len){length=len;};
   void SetWid(float wid){width=wid;};
   void SetCol(string col){color=col;};
   //accessors
   float GetLen(){return length;};
   float GetWid(){return width;};
   string GetCol(){return color;};
   void printItem();
   //overload operator
  // bool operator ==(const CandyWrapper &cdw2)
   //{
     //if( length==cdw2.length)
     // return true;
   
 //  };
}; 
   void CandyWrapper::printItem(){
       cout<<"a length of"<<length<<" in, a width of "<<width<<" in and a "<<color<<" color";
   }






class Candy: public Food
{
private:
  string sweetness;
  CandyWrapper candyWrap;
public:
    
  //operator overloading
  bool operator ==( Candy &candy_2);

  void printItem();
  Candy();
  Candy(Candy const&old);
  //accessors
  float GetLenWR(){return candyWrap.GetLen();};
  //mutators
  void setCandyWrap(CandyWrapper obj);
  void setVolume(float vol);
  void setCalories(float cal);
  void setVegetarian(bool veg);
  void setSweetness(string sweet);
  void setColor(string col);
protected:
  float color;


};


Candy::Candy()
:Food::Food(),sweetness("NA"),candyWrap()
{
  //left empty deliberately
  //calls the candyWrap default construcot
  //calls the Food defaults constrctor
}

Candy::Candy(Candy const&old):Food(old)
{
  sweetness = old.sweetness;
  candyWrap = old.candyWrap;
//how about food?
//how to do volume.
}

void Candy::printItem()
{

Food::printItem();
candyWrap.printItem();
cout<<"and a sweetness level of"<<sweetness;

}

void Candy::setCandyWrap(CandyWrapper obj)
{
  //float len = obj.GetLen();
  //candyWrap.SetLen(len);

  //float wid = obj.GetWid();
  //candyWrap.SetWid(wid);

  //string col = obj.GetCol();
  //candyWrap.SetCol(col);
 candyWrap = obj;
}

void Candy::setVolume(float vol)
{
  Food::setVol(vol);
}

void Candy::setCalories(float cal)
{
  Food::setcal(cal);
}

void Candy::setVegetarian(bool veg)
{
  Food::setVeg(veg);
}

void Candy::setSweetness(string sweet)
{
  sweetness = sweet;
}

void Candy::setColor(string col)
{
  candyWrap.SetCol(col);

}

bool Candy::operator ==(Candy &Candy_2)
{ 
     //if(sweetness == Candy_2.sweetness && candyWrap==Candy_2.candyWrap)
      //return true;
  if(candyWrap.GetLen() == Candy_2.candyWrap.GetLen() && candyWrap.GetCol() == Candy_2.candyWrap.GetCol() && candyWrap.GetWid() == Candy_2.candyWrap.GetWid())
   { if(calories == Candy_2.calories && vegetarian == Candy_2.vegetarian)    
     if(Food::getVol() == Candy_2.getVol())     
        if(sweetness == Candy_2.sweetness)      
        return true;
    }  
    else
    return false;
      





}


int main()
{
Food fd1 = Food(1,200,true);
Food fd2 = Food(fd1);
Candy cd1;
Candy cd2;
CandyWrapper cw1 = CandyWrapper(1,0.5,"red");
CandyWrapper cw2 = CandyWrapper(0.5, 0.25, "blue");
cd1.setVolume(0.05);
cd1.setCalories(100);
cd1.setVegetarian(true);
cd1.setSweetness("0.7");
cd1.setColor("pink");
cd1.setCandyWrap(cw1);
cd2 = cd1;
cd2.setCandyWrap(cw2);
if (fd1 == fd2)
cout << "we are similar !!" << endl << endl;
else
cout << "we are different !!" << endl << endl;
fd1.printItem();
cout << endl;
fd2.printItem();
cout << endl;
if (cd1 == cd2)
cout << "we are similar !!" << endl << endl;
else
cout << "we are different !!" << endl << endl;
cd1.printItem();
cout << endl;
cd2.printItem();
cout << endl;
//system("pause");
return 0;

}
