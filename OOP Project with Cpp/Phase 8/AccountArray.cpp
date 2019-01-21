#include "BankingDeclare.h"
#include "AccountArray.h"

Bound_Check_Account_Ptr_Array::Bound_Check_Account_Ptr_Array(int len)
	:arrlen(len)
{
	arr = new ACCOUNT_PTR[len];
}

ACCOUNT_PTR&  Bound_Check_Account_Ptr_Array::operator[](int idx)
{
	if (idx<0 || idx>arrlen)
	{
		cout << "Array index out of bound exception" << endl;
		exit(1);
	}
	return arr[idx];
}

ACCOUNT_PTR  Bound_Check_Account_Ptr_Array::operator[](int idx) const
{
	if (idx < 0 || idx >= arrlen)
	{
		cout << "Array index out of bound exception" << endl;
		exit(1);
	}
	return arr[idx];
}

int  Bound_Check_Account_Ptr_Array::GetArrLen() const
{
	return arrlen;
}

Bound_Check_Account_Ptr_Array::~Bound_Check_Account_Ptr_Array()
{
	delete[]arr;
}
