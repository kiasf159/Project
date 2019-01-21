//Control Class
#ifndef __ACCOUNT_HANDLER_H__
#define __ACCOUNT_HANDLER_H__

#include "Account.h"
#include "AccountArray.h"

class AccountHandler
{
private:
	Bound_Check_Account_Ptr_Array accArr; //differences from previous version
	int accNum;
protected:
	void MakeNormalAccount();
	void MakeCreditAccount();
public:
	AccountHandler();
	void ShowMenu(void) const;
	void Make_Account();
	void Deposit_Money();
	void Withdraw_Money();
	void Account_Information_Output() const;
	~AccountHandler();
};
#endif // !__ACCOUNT_HANDLER_H__
