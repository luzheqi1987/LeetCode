#include <iostream>
#include <vector>

using namespace std;

bool isNext(string pre, string next) {
  int gap = 0;
  for (int i = 0; i < pre.length(); i++) {
    while (pre[i] != next[i + gap]) {
      if (++gap > 1) {
        return false;
      }
    }
  }
  return true;
}

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
  int start = 0, end = 0;
  std::vector<int> maxLen(words.size(), 1);
  maxLen[0] = 1;
  int maxLength = 1;
  while (end < words.size() && words[end].length() == words[start].length()) {
    end++;
  }
  for (int i = end; i < words.size(); i++) {
    if (i != end && words[i].length() != words[i - 1].length()) {
      start = end;
      end = i;
    }
    for (int j = start; j < end; j++) {
      if (isNext(words[j], words[i])) {
        maxLen[i] = max(maxLen[i], maxLen[j] + 1);
        maxLength = max(maxLen[i], maxLength);
      }
    }
  }
  return maxLength;
}

int main(int argc, char* argv[]) {
  vector<string> strs = {"a", "b", "ba", "bca", "bda", "bdca"};
  int maxLength = longestStrChain(strs);
  cout << maxLength;
  return 1;
}