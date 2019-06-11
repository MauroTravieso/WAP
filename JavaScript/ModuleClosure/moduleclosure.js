"use strict";

(function () {
    let accountInfoList = [];
    window.onload = onLoad; 
    
    function onLoad(){
        document.getElementById("create").onclick = createAcc;
    }

    function createAcc(){
        let acc = account();
        acc.createAccount();
        
        if(validateData(acc.accountName())){
            if(validateData(acc.balance()) === false)
                return;
        } else
            return;

        accountInfoList.push(acc);
        displayAccount();
    }

    function displayAccount() {
        console.log(accountInfoList);
        let s="";
        for (let i=0;i<accountInfoList.length; i++){
            s = s + "Account name: " + accountInfoList[i].accountName() + "\t<--> ";
            s = s + "Balance: " + accountInfoList[i].balance() + "\n";
        }

        document.getElementById("output").value = s;
    }

    function validateData(data) {
        if (data === "") {
            alert("Account name and deposit amout required!")
            return false;
        }
        return true;
    }
})();

var account = (function() {
    var name;
    var deposit;

    return {
        accountName: function() {return name;},
        balance: function() {return deposit;},
        createAccount: function() {
            name = document.getElementById("account").value;
            deposit = document.getElementById("deposit").value;
        }
    }
});

