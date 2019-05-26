#include <iostream>
#include <vector>

using namespace std;

int lastStoneWeightII(vector<int>& stones) {
    int sumWeight = 0;
    int dp[1501] = {0};
    dp[0] = 1;
    for(int i = 0; i < stones.size(); i++){
        sumWeight += stones[i];
        for(int j = 1500; j >= stones[i]; j--){
            dp[j] = dp[j] + dp[j - stones[i]];
        }
    }
    for(int j = sumWeight / 2 ; j > 0 ; j--){
        if(dp[j]) return sumWeight - j - j;
    }
    return 0;
}

int main(int argc, char* argv[]) {
  vector<int> stones = {1,1,4,2,2};
  int last_stone_weight = lastStoneWeightII(stones);
  cout << last_stone_weight << endl;
  return 0;
}