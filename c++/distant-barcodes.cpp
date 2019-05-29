#include <iostream>
#include <vector>

using namespace std;

vector<int> rearrangeBarcodes(vector<int>& barcodes) {
  for (int i = 2; i < barcodes.size(); i++) {
  }
  return barcodes;
}

int main(int argc, char* argv[]) {
  const vector<int> barcodes = {1, 1, 4, 2, 1, 3};
  const int ccc = 4;
  // barcodes.push_back(ccc);
  decltype(barcodes.size()) length = barcodes.size();
  // barcodes[length - 1] = 7;
  int a = 3, b = 4;
  int z = 3.14;
  decltype(a) c = a;
  decltype(a = b) d = a;
  cout << 1 << endl;
  return 0;
}