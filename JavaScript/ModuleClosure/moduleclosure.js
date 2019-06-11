"use strict";

//IIFE - Immediate Invoked Function Expression
//Module Object
(function () {
    let accountInfoList = [];
    
    window.onload = onLoad; 
    
    function onLoad(){
        document.getElementById("create").onclick = createAcc;
    }

    function createAcc(){
        let acc = account();
        console.log(acc);
        //acc function invocation 
        acc.createAccount();
        
        //validate before including in the array
        if(validateData(acc.accountName())){
            if(validateData(acc.balance()) === false)
                return;
        } else
            return;

        //pushing into the array
        accountInfoList.push(acc);

        //display object information
        displayAccount();
    }

    function displayAccount() {
        //in the console
        console.log(accountInfoList);
       
        //in the textarea
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

//Account object
var account = (function() {
    var name;
    var deposit;

    return {
        //closure - name and deposit are free variables
        accountName: function() {return name;},
        balance: function() {return deposit;},
        createAccount: function() {
            //closure - name and deposit are free variables
            name = document.getElementById("account").value;
            deposit = document.getElementById("deposit").value;
        }
    }
});

