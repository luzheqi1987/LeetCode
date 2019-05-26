#include <iostream>
#include <list>
#include <map>
#include <vector>

using namespace std;

/*
    dp[i][j] = dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]
*/
int minScoreTriangulation(vector<int>& A) {
  vector<vector<int>> dp(A.size(), vector<int>(A.size(), 0));

  for (int i = A.size() - 1; i >= 0; i--) {
    for (int j = i + 1; j < A.size(); j++) {
      for (int k = i + 1; k < j; k++) {
        dp[i][j] = min(dp[i][j] == 0 ? INT_MAX : dp[i][j],
                       dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
      }
    }
  }
  return dp[0][A.size() - 1];
}

int dp[50][50] = {};
int minScoreTriangulation_top_down(vector<int>& A, int i = 0, int j = 0, int res = 0) {
  if (j == 0) j = A.size() - 1;
  if (dp[i][j] != 0) return dp[i][j];
  for (auto k = i + 1; k < j; ++k) {
    res = min(res == 0 ? INT_MAX : res, 
      minScoreTriangulation_top_down(A, i, k) + A[i] * A[k] * A[j] + minScoreTriangulation_top_down(A, k, j));
  }
  return dp[i][j] = res;
}

int main(int argc, char* argv[]) {
  vector<int> numbers = {1, 2, 3, 45, 7, 8, 9};
  int sum = minScoreTriangulation(numbers);
  cout << sum << endl;
}