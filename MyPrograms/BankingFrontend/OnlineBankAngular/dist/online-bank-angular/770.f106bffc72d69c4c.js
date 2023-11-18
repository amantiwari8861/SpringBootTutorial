"use strict";(self.webpackChunkOnlineBankAngular=self.webpackChunkOnlineBankAngular||[]).push([[770],{770:(g,p,t)=>{t.r(p),t.d(p,{EmployeeModule:()=>f});var d=t(9808),u=t(2382),i=t(7038),r=t(1223);const c=[{path:"",canActivate:[]}];let m=(()=>{class o{}return o.\u0275fac=function(e){return new(e||o)},o.\u0275mod=r.oAB({type:o}),o.\u0275inj=r.cJS({imports:[[i.Bz.forChild(c)],i.Bz]}),o})();var a=t(520),y=t(2843),h=t(8505),n=t(262);let E=(()=>{class o{constructor(e){this.http=e,this.employeesUrl="http://localhost:9090/employees",this.options=new a.WM({"Content-Type":"application/json"})}getEmployees(){return this.http.get(this.employeesUrl).pipe((0,h.b)(e=>console.log("Data Fetched:"+JSON.stringify(e))),(0,n.K)(this.handleError))}addEmployee(e){return this.http.post(this.employeesUrl,e,{headers:this.options}).pipe((0,n.K)(this.handleError))}updateEmployee(e){return this.http.put(this.employeesUrl,e,{headers:this.options}).pipe((0,h.b)(s=>console.log(`updated Employee id=${e.empid}`)),(0,n.K)(this.handleError))}deleteEmployee(e){return this.http.delete(`${this.employeesUrl}/${e}`).pipe((0,n.K)(this.handleError))}handleError(e){let s="";return e.error instanceof Error?(console.log("An error occurred:",e.error.message),s=e.error.message):(console.log(`Backend returned code ${e.status}`),s=e.error.status),(0,y._)(()=>s)}}return o.\u0275fac=function(e){return new(e||o)(r.LFG(a.eN))},o.\u0275prov=r.Yz7({token:o,factory:o.\u0275fac,providedIn:"root"}),o})(),f=(()=>{class o{}return o.\u0275fac=function(e){return new(e||o)},o.\u0275mod=r.oAB({type:o}),o.\u0275inj=r.cJS({providers:[E],imports:[[d.ez,u.u5,m]]}),o})()}}]);