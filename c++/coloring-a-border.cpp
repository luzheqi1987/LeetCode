#include <iostream>
#include <vector>

using namespace std;

void recursion(vector<vector<int>>& result, vector<vector<int>>& grid, int r0,
               int c0, int color, int raw, int row, int col, int direction);

vector<vector<int>> colorBorder(vector<vector<int>>& grid, int r0, int c0,
                                int color) {
  vector<vector<int>> result(grid.size(), vector<int>(grid[0].size(), 0));
  int row = grid.size() - 1;
  int col = grid[0].size() - 1;
  recursion(result, grid, r0, c0, color, grid[r0][c0], row, col, -1);
  for (int i = 0; i < grid.size(); i++) {
    for (int j = 0; j < grid[0].size(); j++) {
      if (result[i][j] == 0) {
        result[i][j] = grid[i][j];
      }
    }
  }
  return result;
}

void recursion(vector<vector<int>>& result, vector<vector<int>>& grid, int r0,
               int c0, int color, int raw, int row, int col, int direction) {
  bool isBorder = false;

  if ((r0 - 1) < 0 || (r0 + 1) > row || (c0 - 1 < 0) || (c0 + 1) > col) {
    result[r0][c0] = color;
  } else if (((r0 - 1) >= 0 && grid[r0 - 1][c0] != raw) ||
             ((r0 + 1) <= row && grid[r0 + 1][c0] != raw) ||
             ((c0 + 1) <= col && grid[r0][c0 + 1] != raw) ||
             ((c0 - 1) >= 0 && grid[r0][c0 - 1] != raw)) {
    result[r0][c0] = color;
  } else {
    result[r0][c0] = grid[r0][c0];
  }

  if (direction != 2) {
    if (r0 - 1 >= 0) {
      if (grid[r0 - 1][c0] != raw) {
        isBorder = true;
      } else {
        if (result[r0 - 1][c0] == 0) {
          recursion(result, grid, r0 - 1, c0, color, raw, row, col, 0);
        }
      }
    } else {
      isBorder = true;
    }
  }

  if (direction != 3) {
    if (c0 + 1 <= col) {
      if (grid[r0][c0 + 1] != raw) {
        isBorder = true;
      } else {
        if (result[r0][c0 + 1] == 0) {
          recursion(result, grid, r0, c0 + 1, color, raw, row, col, 1);
        }
      }
    } else {
      isBorder = true;
    }
  }

  if (direction != 0) {
    if (r0 + 1 <= row) {
      if (grid[r0 + 1][c0] != raw) {
        isBorder = true;
      } else {
        if (result[r0 + 1][c0] == 0) {
          recursion(result, grid, r0 + 1, c0, color, raw, row, col, 2);
        }
      }
    } else {
      isBorder = true;
    }
  }

  if (direction != 1) {
    if (c0 - 1 >= 0) {
      if (grid[r0][c0 - 1] != raw) {
        isBorder = true;
      } else {
        if (result[r0][c0 - 1] == 0) {
          recursion(result, grid, r0, c0 - 1, color, raw, row, col, 3);
        }
      }
    } else {
      isBorder = true;
    }
  }
}

int main(int argc, char* argv[]) {
  vector<vector<int>> grid = {{1, 2, 2}, {2, 3, 2}};
  vector<vector<int>> result = colorBorder(grid, 0, 1, 3);
  for (int i = 0; i < grid.size(); i++) {
    for (int j = 0; j < grid[0].size(); j++) {
      printf("%d\t", result[i][j]);
    }
    printf("\n");
  }
  return 0;
}