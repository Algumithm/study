#include <iostream>
#include <deque>
using namespace std;
int n;


int main(){
    cin>>n;
    deque<int> cards;
    for(int i=1; i<=n; ++i){
        cards.push_back(i);
    }

    while(1<cards.size()){
        cards.pop_front();
        cards.push_back(cards[0]);
        cards.pop_front();
    }

    cout<<cards[0]<<"\n";

    return 0;
}
