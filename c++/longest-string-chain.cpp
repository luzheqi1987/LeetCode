#include <iostream>
#include <vector>

using namespace std;

int longestStrChain(vector<string>& words) {
  sort(words.begin(), words.end(), [](string a, string b) {
    if (a.length() < b.length()) {
      return true;
    } else if (a.length() > b.length()) {
      return false;
    } else {
      return a < b;
    }
  });
  for (auto val : words) {
    cout << val << endl;
  }
  return -1;
}

int main(int argc, char* argv[]) {
  vector<string> strs = {"ac", "a", "ab", "b", "ba"};
  longestStrChain(strs);
  return 1;
}