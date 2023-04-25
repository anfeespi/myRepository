#include<bits/stdc++.h>
#include<cstdlib>
#define x first
#define y second
#define all(x) x.begin(),x.end()
#define sz(A) (int)(A.size())
#define forn(i, n) for(int i = 0; i < int(n); i++)
#define ld __float128
#define me(a, x) memset(a, x, sizeof(a))
#define PI acos(-1)
#define INF 99999
#define FAST ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(0);
using namespace std;
using i64 = uint64_t;
using ll = long long;
using ull = unsigned long long int;
using db = long double;
using str = string;


typedef pair<ll, ll> pi;
typedef std::numeric_limits< db > dbl;

template <class A, class B> ostream& operator << (ostream& out, const pair<A, B> &a) {
    return out << "(" << a.x << ", " << a.y << ")";
}

template <class A> ostream& operator << (ostream& out, const vector<A> &v) {
    out << "[";
    forn(i, sz(v)) {
        if(i) out << ", ";
        out << v[i];
    }
    return out << "]";
}

template <class A> ostream& operator << (ostream& out, const set<A> &v) {
    out << "{";
    for(A i: v) {
        out << i;
        if(i) out << ", ";
    }
    return out << "}";
}

int main() {
    FAST;
    int n,m;
    cin>>n>>m;
    vector<int>arr(n, 0);
    vector<int>ice(n, 0);
    int temp = 0;
    int index = 0;
    for(int &i:arr){
        cin>>i;
        if(i<0){
            ice[index] = abs(i/5);
            if(index){
                if(ice[index] && ice[index-1]){
                    ice[index]+=ice[index-1];
                }
            }
        }
        index++;
    }
    for(int i=0;i<m;i++){
        int p;
        cin>>p;
        int _ans = 0;
        for(int j:ice){
            if(!j)continue;
            _ans += ((int)j>=p)?1:0;
        }
        cout<<_ans<<" ";
    }
    return 0;
}