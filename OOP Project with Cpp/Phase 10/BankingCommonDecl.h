#ifndef  __BANKING_COMMON_H__
#define  __BANKING_COMMON_H__

#include <iostream>
#include <cstring>
#include <cstdlib>

using namespace std;
const int NAME_LEN = 20;

//Select Menu of Program User
enum {MAKE = 1, DEPOSIT, WITHDRAW, INQUIRE, EXIT};

//Credit Grade
enum {LEVEL_A = 8, LEVEL_B = 5, LEVEL_C = 2};

//Type of Account
enum { NORMAL = 1, CREDIT = 2};

#endif // ! __BANKING_COMMON_H__
