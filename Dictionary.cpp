#include <bits/stdc++.h>

using namespace std;

int main() {
    int q, c;
    cin>>q>>c;

    string w[q];

    for (int i = 0; i < q; i++) {
        cin>>w[i];
    }

    sort(w, w + q);

    for (int m = 0; m < c; m++) {
        string s1, s2;
        cin>>s1>>s2;

        int beg = lower_bound(w, w + q, s1) - w;

        int end = lower_bound(w, w + q, s2) - w;
        if (end < q && w[end] == s2) {
            end++;
        }

        cout<<max(0, end - beg)<<endl;
    }

    return 0;
}