#include <iostream>
#include <vector>

using namespace std;

vector<int> rearrangeBarcodes(vector<int>& barcodes) {
    for(int i = 2; i < barcodes.size(); i++){

    }
    return barcodes;
}

int main(int argc, char* argv[]) {
  vector<int> barcodes = {1, 1, 4, 2, 1, 3};
  vector<int> B = rearrangeBarcodes(barcodes);
  for (int i : B) {
    cout << i << " ";
  }
  cout << endl;
  return 0;
}