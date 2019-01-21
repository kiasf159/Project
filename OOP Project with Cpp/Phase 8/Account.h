#ifndef __ACCOUNT_H__
#define __ACCOUNT_H__

// Entity Class, Top
class Account
{
private:
	int accID;
	int balance;
	char *cusName;
public:
	Account(int ID, int money, char *name);
	Account(const Account &ref);
	Account& operator=(const Account &ref); // differences from previous version

	int GetAccID() const;
	void Deposit(int money);
	int Withdraw(int money);
	void ShowAccInfo() const;
	~Account();
};

#endif
