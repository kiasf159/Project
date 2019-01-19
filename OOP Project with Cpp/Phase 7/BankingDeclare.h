#ifndef __BANKINGDECLARE_H__
#define __BANKINGDECLARE_H__

#include <iostream>
#include <cstring>
#pragma warning(disable : 4996)
using namespace std;
const int NAME_LEN = 20;

// Select
enum { MAKE = 1, DEPOSIT, WITHDRAW, INQUIRE, EXIT };

//Credit Grade
enum { LEVEL_A = 7, LEVEL_B = 4, LEVEL_C = 2 };

//Type of Account
enum { NORMAL = 1, CREDIT = 2 };

#endif // !__BANKINGDECLARE_H__

