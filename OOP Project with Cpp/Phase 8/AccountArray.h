#ifndef __ACCOUNT_ARRAY__
#define __ACCOUNT_ARRAY__

#include "Account.h"
typedef Account *ACCOUNT_PTR;

class Bound_Check_Account_Ptr_Array
{
private:
	ACCOUNT_PTR *arr;
	int arrlen;
	Bound_Check_Account_Ptr_Array(const  Bound_Check_Account_Ptr_Array& arr) {   }
	Bound_Check_Account_Ptr_Array &operator=(const  Bound_Check_Account_Ptr_Array &arr) {   }
public:
	Bound_Check_Account_Ptr_Array(int len = 100);
	ACCOUNT_PTR& operator[] (int idx);
	ACCOUNT_PTR operator[] (int idx) const;
	int GetArrLen() const;
	~Bound_Check_Account_Ptr_Array();
};
#endif // !__ACCOUNT_ARRAY__
