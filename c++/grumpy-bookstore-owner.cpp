#include <iostream>
#include <vector>

using namespace std;

int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int X) {
  int maxGap = 0, sum3 = 0, real3 = 0;
  int sum = 0;
  for (int i = 0; i < customers.size(); i++) {
    if (!grumpy[i]) {
      sum += customers[i];
    }
    if (i < X - 1) {
      sum3 += customers[i];
      real3 += grumpy[i] ? 0 : customers[i];
    } else {
      sum3 += customers[i];
      real3 += grumpy[i] ? 0 : customers[i];

      maxGap = max(maxGap, sum3 - real3);

      sum3 -= customers[i - X + 1];
      real3 -= grumpy[i - X + 1] ? 0 : customers[i - X + 1];
    }
  }
  return sum + maxGap;
}

int main(int argc, char* argv[]) {
  vector<int> customers = {1};
  vector<int> grumpy = {0};
  int sum = maxSatisfied(customers, grumpy, 3);
  cout << sum << endl;
  return 0;
}
