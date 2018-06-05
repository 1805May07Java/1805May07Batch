package com.major.util;

import com.major.pojos.ErsUser;
import com.major.pojos.FullView;
import com.major.pojos.Reimbursement;
import com.major.pojos.UserView;

public class ViewService 
{
	static LookupService looker = new LookupService();
	static UserService useServe = new UserService();
	static ReimbursementService ReimbServe = new ReimbursementService();
	
	public FullView assembleFullView(ErsUser author, ErsUser resolver,Reimbursement claim)
	{
		FullView out = new FullView();
		out.setId(claim.getId());
		out.setAuthorFirst(author.getFirstName());
		out.setAuthorLast(author.getLastName());
		out.setAmount(claim.getAmount());
		out.setDescription(claim.getDescription());
		out.setSubmit(claim.getTimeSubmitted());
		if(claim.getTimeResolved()!=null) {
		out.setResolved(claim.getTimeResolved());
		}else{out.setResolved("");}
		out.setType(looker.getType(claim.getTypeId()).getType());
		out.setStatus(looker.getStatus(claim.getStatusId()).getStatus());
		if(resolver.getFirstName()!=null) 
		{
		out.setResolverFirst(resolver.getFirstName());
		out.setResolverLast(resolver.getLastName());
		out.setResolvId(resolver.getId());
		}
		else 
		{
			out.setResolverFirst("");
			out.setResolverLast("");
			out.setResolvId(0);
		}
		out.setReqId(author.getId());
		
		

		return out;	
	}
	
	public UserView assembleUserView(ErsUser viewed) 
	{
		UserView out = new UserView();
		out.setId(viewed.getId());
		out.setUserName(viewed.getUserName());
		out.setEmail(viewed.getEmail());
		out.setFirstName(viewed.getFirstName());
		out.setLastName(viewed.getLastName());
		out.setPassword(viewed.getPassword());
		out.setRole(looker.getRole(viewed.getRoleId()).getRole());
		return out;
	}
	
	public Reimbursement disassembleFullView(FullView view) 
	{
		Reimbursement out = new Reimbursement();
		out.setId(view.getId());
		out.setAmount(view.getAmount());
		out.setDescription(view.getDescription());
		out.setRequesterId(view.getReqId());
		out.setStatusId(looker.getStatusId(view.getStatus()));
		out.setTimeSubmitted(view.getSubmit());
		out.setTypeId(looker.getTypeId(view.getType()));	
		if(view.getResolverFirst()!=null) 
		{
		out.setResolverId(view.getResolvId());
		out.setTimeResolved(view.getResolved());
		}
		else 
		{
			out.setResolverId(0);
			out.setTimeResolved("");
		}
		return out;
	}
	
	public ErsUser disassembleFullViewAuthor(FullView view) 
	{
		ErsUser out = new ErsUser();
		out = useServe.getById(view.getReqId());
		return out;
	}
	
	public ErsUser disassembleFullViewResolver(FullView view) 
	{
		ErsUser out = new ErsUser();
		out = useServe.getById(view.getResolvId());
		return out;
	}
	
	public ErsUser disassembleUserView(UserView view) 
	{
		ErsUser out = new ErsUser();
		out.setEmail(view.getEmail());
		out.setFirstName(view.getFirstName());
		if(view.getId()!=0) 
		{
		out.setId(view.getId());
		}
		out.setLastName(view.getLastName());
		out.setPassword(view.getPassword());
		out.setRoleId(looker.getRoleId(view.getRole()));
		out.setUserName(view.getUserName());
		return out;
	}
	
}
