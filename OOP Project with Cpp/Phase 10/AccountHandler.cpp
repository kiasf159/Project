#include "BankingCommonDecl.h"
#include "AccountHandler.h"
#include "Account.h"
#include "String.h"
#include "NormalAccount.h"
#include "HighCreditAccount.h"

void AccountHandler::ShowMenu() const
{
	cout << "-----Menu------" << endl;
	cout << "1. Opening an Account" << endl;
	cout << "2. Deposit" << endl;
	cout << "3. Withdrawal" << endl;
	cout << "4. Print out Account Information" << endl;
	cout << "5. Program Close." << endl;
}

void AccountHandler::MakeAccount()
{
	int sel;
	cout << "[Type of Account]" << endl;
	cout << "1. Normal Account" << endl;
	cout << "2. Credit Account" << endl;
	cout << "Select : ";
	cin >> sel;

	if (sel == NORMAL)
		MakeNormalAccount();
	else
		MakeCreditAccount();
}

void AccountHandler::MakeNormalAccount()
{
	int id;
	char name[NAME_LEN];
	int balance;
	int interRate;

	cout << "[Opening an NormalAccount]" << endl;
	cout << "Account ID : ";
	cin >> id;
	cout << "Name : ";
	cin >> name;
	cout << "Deposit money : ";
	cin >> balance;
	cout << "interRate : ";
	cin >> interRate;
	cout << endl;

	accArr[accNum++] = new NormalAccount(id, balance, name, interRate);
}

void AccountHandler::MakeCreditAccount()
{
	int id;
	char name[NAME_LEN];
	int balance;
	int interRate;
	int credit_level;

	cout << "[Opening an NormalAccount]" << endl;
	cout << "Account ID : ";
	cin >> id;
	cout << "Name : ";
	cin >> name;
	cout << "Deposit money : ";
	cin >> balance;
	cout << "interRate : ";
	cin >> interRate;
	cout << "Credit Level(1 = A, 2 = B, 3 = C) : ";
	cin >> credit_level;
	cout << endl;

	switch (credit_level)
	{
	case 1:
		accArr[accNum++] = new HighCreditAccount(id, balance, name, interRate, LEVEL_A);
		break;
	case 2:
		accArr[accNum++] = new HighCreditAccount(id, balance, name, interRate, LEVEL_B);
		break;
	case 3:
		accArr[accNum++] = new HighCreditAccount(id, balance, name, interRate, LEVEL_C);
	}
}

void AccountHandler::DepositMoney()
{
	int money;
	int id;
	cout << "[Deposit Corner]" << endl;
	cout << "Account ID : ";
	cin >> id;
	while (1)
	{
		cout << "Deposit money : ";
		cin >> money;
		try
		{
			for (int i = 0; i < accNum; i++)
			{
				if (accArr[i]->GetAccID() == id)
				{
					accArr[i]->Deposit(money);
					cout << "Deposit Complete" << endl;
					return;
				}
			}
			cout << "It's not found. " << endl;
			return;
		}
		catch (MinusException &expt)
		{
			expt.ShowExceptionInfo();
			cout << "Re - Input Deposit money" << endl;
		}
	}
}

void AccountHandler::WithdrawMoney()
{
	int money;
	int id;
	cout << "[Withdrawal]" << endl;
	cout << "Account ID : ";
	cin >> id;
	while (1)
	{
		cout << "Withdrawal money : ";
		cin >> money;
		try
		{
			for (int i = 0; i < accNum; i++)
			{
				if (accArr[i]->GetAccID() == id)
				{
					if (accArr[i]->Withdraw(money) == 0)
					{
						cout << "Balance Shortage.." << endl;
						return;
					}
					cout << "Withdrawal Complete" << endl;
					return;
				}
			}
			cout << "It's not found." << endl;
			return;		
		}
		catch (MinusException &expt)
		{
			expt.ShowExceptionInfo();
			cout << "Re - Input Withdraw money." << endl;
		}
	}
}

AccountHandler::AccountHandler()
	:accNum(0)
{  }

void AccountHandler::ShowAllAccInfo() const
{
	for (int i = 0; i < accNum; i++)
	{
		accArr[i]->ShowAccInfo();
		cout << endl;
	}
}

AccountHandler::~AccountHandler()
{
	for (int i = 0; i < accNum; i++)
		delete accArr[i];
}
