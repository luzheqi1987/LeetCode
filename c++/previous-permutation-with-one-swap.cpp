#include <iostream>
#include <vector>

using namespace std;

vector<int> prevPermOpt1(vector<int>& A) {
    int index = 0;
    bool diff = false;
    for(int i = 0; i < A.size() - 1; i++){
        if(A[i] > A[i + 1]){
            diff = true;
            index = i;
        }
    }
    if(!diff){
        return A;
    }else{
        int max = index + 1;
        for(int i = max + 1; i < A.size(); i++){
            if(A[i] < A[index] && A[i] > A[max]){
                max = i;
            }
        }
        int tmp = A[max];
        A[max] = A[index];
        A[index] = tmp;
    }
    return A;
}

int main(int argc, char* argv[]) {
  vector<int> A = {3,1,1,3};
  vector<int> B = prevPermOpt1(A);
  for(int i : B){
    cout << i << " ";
  } 
  cout << endl;
  return 0;
}
