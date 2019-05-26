#include <iostream>
#include <vector>

using namespace std;

int heightChecker(vector<int>& heights) {
  vector<int> order;
  for (int num : heights) {
    order.push_back(num);
  }
  sort(order.begin(), order.end());
  int sum = 0;
  for (int i = 0; i < heights.size(); i++) {
    if (heights[i] != order[i]) {
      sum++;
    }
  }
  return sum;
}

int main(int argc, char* argv[]) {
  vector<int> heights = {1, 1, 4, 2, 1, 3};
  int sum = heightChecker(heights);
  cout << sum << endl;
  return 0;
}