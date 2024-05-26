#include <iostream>
#include <vector>
#include <string>

using namespace std;

string decimalToBinary(int n) {
    string binary = "";
    for (int i = 7; i >= 0; --i) {
        binary += ((n & (1 << i)) ? '1' : '0');
    }
    return binary;
}

int getNewState(int left, int center, int right, const string &rule) {
    int index = 7 - (left * 4 + center * 2 + right);
    return rule[index] - '0';
}

vector<string> cellularAutomaton(int ruleNumber, int generations, const string &initialState) {
    string rule = decimalToBinary(ruleNumber);
    vector<int> currentState;

    for (char c : initialState) {
        currentState.push_back(c == 'X' ? 1 : 0);
    }

    auto stateToString = [](const vector<int> &state) {
        string result = "";
        for (int cell : state) {
            result += (cell ? 'X' : '.');
        }
        return result;
    };

    vector<string> result;
    result.push_back(stateToString(currentState));

    for (int g = 0; g < generations; ++g) {
        vector<int> newState(currentState.size(), 0);
        int length = currentState.size();

        for (int i = 0; i < length; ++i) {
            int left = (i > 0) ? currentState[i - 1] : 0;
            int center = currentState[i];
            int right = (i < length - 1) ? currentState[i + 1] : 0;
            newState[i] = getNewState(left, center, right, rule);
        }

        currentState = newState;
        result.push_back(stateToString(currentState));
    }

    return result;
}

int main() {
    int R, K;
    cin >> R >> K;
    string initialState;
    cin >> initialState;

    vector<string> result = cellularAutomaton(R, K, initialState);

    for (const string &line : result) {
        cout << line << endl;
    }

    return 0;
}
