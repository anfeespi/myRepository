#include<bits/stdc++.h>

using namespace std;

int main(){
    string s;
    multimap<string, string> uebfa;

    while(cin>>s && s != "#"){
        string t(s);

        transform(s.begin(), s.end(), t.begin(), ::tolower);
        sort(t.begin(), t.end());
        uebfa.insert(pair<string, string>(t, s));
    }

    multimap<string, string>::iterator iter(uebfa.begin());
    vector<string> ananagrams;
    for (; iter != uebfa.end(); ++iter)
        if (uebfa.count(iter->first) == 1)
            ananagrams.push_back(iter->second);

    sort(ananagrams.begin(), ananagrams.end());
    copy(ananagrams.begin(), ananagrams.end(), ostream_iterator<string>(cout, "\n"));
}
