#include <iostream>
#include <vector>

using namespace std;

int maxSumTwoNoOverlap(vector<int>& A, int L, int M) {
  vector<int>::size_type length = A.size();
  if (length < L + M) {
    return 0;
  }
  vector<int> maxL(length, 0);
  vector<int> maxM(length, 0);
  int sumL = 0;
  int sumM = 0;
  int result = INT_MIN;
  for (vector<int>::size_type i = 0; i != length; ++i) {
      sumL += A[i];
      if (i >= L) {
        sumL -= A[i - L];
      }
      if (i == 0) {
        maxL[i] = sumL;
      } else {
        maxL[i] = max(sumL, maxL[i - 1]);
      }
    

      sumM += A[i];
      if (i >= M) {
        sumM -= A[i - M];
      }
      if (i == 0) {
        maxM[i] = sumM;
      } else {
        maxM[i] = max(sumM, maxM[i - 1]);
      }
    
    if (i >= L + M - 1) {
      result = max(result, max(sumM + maxL[i - M], sumL + maxM[i - L]));
    }
  }
  return result;
}

int main(int argc, char* argv[]) {
  vector<int> A = {2,1,5,6,0,9,5,0,3,8};
  int result = maxSumTwoNoOverlap(A, 4, 3);
  cout << result << endl;
  return 0;
}
