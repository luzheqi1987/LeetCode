#include <iostream>
#include <vector>

using namespace std;

int lastStoneWeight(vector<int>& stones) {
  if (stones.size() == 1) {
    return stones[0];
  } else if (stones.size() == 0) {
    return 0;
  }
  sort(stones.begin(), stones.end());
  int length = stones.size();
  while (length > 1) {
    int max1 = stones[length - 1];
    int max2 = stones[length - 2];

    if (max1 == max2) {
      length -= 2;
    } else {
      int newWeight = max1 - max2;
      int i = length - 2;
      for (; i >= 1; i--) {
        if (stones[i - 1] > newWeight) {
          stones[i] = stones[i - 1];
        } else {
          stones[i] = newWeight;
          break;
        }
      }
      if (i == 0) {
        stones[i] = newWeight;
      }
      length--;
    }
  }
  return length == 0 ? 0 : stones[0];
}

int main(int argc, char* argv[]) {
  vector<int> stones = {2, 7, 4, 1, 8, 1};
  int last_stone_weight = lastStoneWeight(stones);
  cout << last_stone_weight << endl;
  return 0;
}