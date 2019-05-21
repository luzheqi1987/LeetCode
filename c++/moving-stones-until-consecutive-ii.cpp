#include <iostream>
#include <vector>

using namespace std;

vector<int> numMovesStonesII(vector<int>& stones) {
  int n = stones.size();
  int start = 0;
  int mmm = INT_MIN;
  sort(stones.begin(), stones.end());
  for (int i = 0; i < stones.size(); i++) {
    while (stones[i] - stones[start] > n - 1) {
      start++;
    }
    mmm = max(mmm, i - start + 1);
  }
  int maxNum =
      max(stones[n - 2] - stones[0] - 1, stones[n - 1] - stones[1] - 1) -
      (n - 3);
  if (stones.back() - stones[0] > n && (stones[n - 1] - stones[1] == n - 2 ||
                                        stones[n - 2] - stones[0] == n - 2)) {
    mmm--;
  }
  int minNum = n - mmm;
  return {minNum, maxNum};
}

int main(int argc, char* argv[]) {
  vector<int> numbers = {1, 2, 3, 45, 7, 8, 9};
  vector<int> result = numMovesStonesII(numbers);
  cout << result[0] << '\t' << result[1] << endl;
  cout << "hello world!" << endl;
  return 0;
}
