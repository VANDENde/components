package com.basiscomponents.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.basis.bbj.client.datatypes.BBjVector;
import com.basis.util.common.BBjNumber;

public class DataRow 
{

	private HashMap<String,DataField> FieldList = new HashMap<>();
	private ArrayList<String> FieldNames=new ArrayList<>();
	private String Tpl;

	public DataRow(String tpl)
	{
		this.Tpl = tpl;
	}
	
	public DataRow(String tpl, String rec) throws Exception
	{
		this(tpl);
		setString(rec);
	}

	public DataRow() {
		// TODO Auto-generated constructor stub
	}

	public static DataRow newInstance()
	{
		return new DataRow();
	}

	public void setString (String rec) throws Exception
	{
		throw new Exception("Not yet implemented");
//		BBjTemplatedString x;
//		x=BBjAPI.makeTemplatedString(this.Tpl.getBytes());
//        x.setString(rec)
//        dim x1:this.Tpl
//        fields=fattr(x1,"")
//
//        while fields>""
//            p=pos(0a=fields)
//            f=fields(1,p-1)
//            fields=fields(p+1)
//
//            fieldtype=asc(fattr(x1,f)(1,1))
//
//            if fieldtype=1 or fieldtype=11 then
//                this.setFieldValue(f,x.getFieldAsString(f))
//            else
//                this.setFieldValue(f,x.getFieldAsNumber(f))
//            fi
//
//
//            x=this.Tpl(pos(f+":"=this.Tpl)+len(f)+2)
//            x=x(pos("("=x)+1)
//            x=x(1,pos(")"=x)-1)
//
//            if pos("*"=x)>0 then
//                x=x(1,pos("*"=x)-1)
//            fi
//
//            if pos("+"=x)>0 then
//                x=x(1,pos("+"=x)-1)
//            fi
//
//            cast(DataField,this.FieldList.get(f)).setLength(num(x))
//        wend
//
	}

	public String toString()
	{

		String x="";
		  
		Iterator<String> it = FieldNames.iterator();
		while (it.hasNext())
		{
			String k=it.next();
			String f = "";
			try {
				f = this.getFieldAsString(k);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x=x+","+k+"="+f;
		}

		if (x.length()>0)
			x="["+x.substring(1)+"]";
		else
		    x="(empty)";

		return x;
	}


	public void setFieldValue(String name, String value) throws Exception
	{
		DataField field=this.FieldList.get(name);
		if (field == null)
		{
			field = new DataField(name,'C',value);
			this.FieldList.put(name,field);
			this.FieldNames.add(name);		
		}
		else
		{
			field.setValue(value);
		}
	}
	
	public void setFieldValue(String name, BBjNumber value) throws Exception
	{
		DataField field=this.FieldList.get(name);
		if (field == null)
		{
			field = new DataField(name,'N',value);
			this.FieldList.put(name,field);
			this.FieldNames.add(name);		
		}
		else
		{
			field.setValue(value);
		}
	}
	
	public void setFieldValue(String name, java.sql.Date value) throws Exception
	{
		DataField field=this.FieldList.get(name);
		if (field == null)
		{
			field = new DataField(name,'D',value);
			this.FieldList.put(name,field);
			this.FieldNames.add(name);		
		}
		else
		{
			field.setValue(value);
		}
	}	
	
	public void setFieldValue(String name, java.sql.Timestamp value) throws Exception
	{
		DataField field=this.FieldList.get(name);
		if (field == null)
		{
			field = new DataField(name,'X',value);
			this.FieldList.put(name,field);
			this.FieldNames.add(name);		
		}
		else
		{
			field.setValue(value);
		}
	}
	
	public void setFieldValue(String name, java.lang.Double value) throws Exception
	{
		DataField field=this.FieldList.get(name);
		if (field == null)
		{
			field = new DataField(name,'N',value);
			this.FieldList.put(name,field);
			this.FieldNames.add(name);		
		}
		else
		{
			field.setValue(value);
		}
	}

	public void setFieldValue(String name, java.lang.Integer value) throws Exception
	{
		DataField field=this.FieldList.get(name);
		if (field == null)
		{
			field = new DataField(name,'I',value);
			this.FieldList.put(name,field);
			this.FieldNames.add(name);		
		}
		else
		{
			field.setValue(value);
		}
	}

	public void setFieldValue(String name, java.lang.Boolean value) throws Exception
	{
		DataField field=this.FieldList.get(name);
		if (field == null)
		{
			field = new DataField(name,'B',value);
			this.FieldList.put(name,field);
			this.FieldNames.add(name);		
		}
		else
		{
			field.setValue(value);
		}
	}

	public void setFieldValue(String name, java.math.BigDecimal value) throws Exception
	{
		DataField field=this.FieldList.get(name);
		if (field == null)
		{
			field = new DataField(name,'Y',value);
			this.FieldList.put(name,field);
			this.FieldNames.add(name);		
		}
		else
		{
			field.setValue(value);
		}
	}	

	public void setFieldValue(String name, java.sql.Time value) throws Exception
	{
		DataField field=this.FieldList.get(name);
		if (field == null)
		{
			field = new DataField(name,'T',value);
			this.FieldList.put(name,field);
			this.FieldNames.add(name);		
		}
		else
		{
			field.setValue(value);
		}
	}


	public Object getField(String name) throws Exception
	{

		DataField field=this.FieldList.get(name);

		if (field == null) 
          	throw new Exception("Field "+name+" does not exist");

		return field.getObject();		
	}

	public String getFieldAsString(String name) throws Exception
	{

		DataField field=this.FieldList.get(name);

		if (field == null) 
          	throw new Exception("Field "+name+" does not exist");

		return field.getValueAsString();		
	}

	public Double getFieldAsNumber(String name) throws Exception
	{

		DataField field=this.FieldList.get(name);

		if (field == null) 
          	throw new Exception("Field "+name+" does not exist");

		return field.getValueAsNumber();		
	}	

	
	public BBjVector getFieldNames()
	{
		BBjVector v = new BBjVector();
		
		Iterator<String> it = this.FieldNames.iterator();
		while (it.hasNext())
		{
			v.addItem(it.next());
		}
		
		return v;
	}
	

	public String getFieldType(String name) throws Exception
	{
		DataField field=this.FieldList.get(name);

		if (field == null) 
          	throw new Exception("Field "+name+" does not exist");

		return Character.toString(field.getType());		
		
	}

	public int getFieldLength(String name) throws Exception
	{
		DataField field=this.FieldList.get(name);

		if (field == null) 
          	throw new Exception("Field "+name+" does not exist");

		return field.getLength();		
		
	}	
	
	public void setFieldAttribute(String name, String attrname, String value) throws Exception
	{
		DataField field=this.FieldList.get(name);

		if (field == null) 
          	throw new Exception("Field "+name+" does not exist");

		field.setAttribute(attrname,value);		
		
	}

	public String getFieldAttribute(String name, String attrname) throws Exception
	{
		DataField field=this.FieldList.get(name);

		if (field == null) 
          	throw new Exception("Field "+name+" does not exist");

		String attr = field.getAttribute(attrname);
		if (attr==null)
				attr="";
				
		return attr;
		
	}

	public HashMap<String,String> getFieldAttributes(String name) throws Exception
	{
		DataField field=this.FieldList.get(name);

		if (field == null) 
          	throw new Exception("Field "+name+" does not exist");

		return field.getAttributes();		
		
	}	

	public void removeFieldAttribute(String name, String attrname) throws Exception
	{
		DataField field=this.FieldList.get(name);

		if (field == null) 
          	throw new Exception("Field "+name+" does not exist");

		 field.removeAttribute(attrname);		
		
	}


	public BBjVector getAttributeForFields(String attrname)
	{
		return this.getAttributeForFields(attrname,false);
	}

//	rem /**
//    rem * Method getAttributeForFields:
//    rem * get all attributes, with a specific attribute name, as a BBjVector
//    rem * @param String attrame: the name of the attribute
//    rem * @param BBjNumber defaultToFieldname: if 1 return the field name if attribute value is empty
//    rem * @return BBjVector vec: a BBjVector with the attributes with the given attribute name
//    rem */
	public BBjVector getAttributeForFields(String attrname, Boolean defaultToFieldname)
	{
		DataField field;
		BBjVector ret = new BBjVector();

        if (this.FieldNames.size()>0) 
        {
        	Iterator<String> it = this.FieldNames.iterator();
        	while (it.hasNext())
        	{
        		String n=it.next();
        		field = this.FieldList.get(n);
                String r = field.getAttribute(attrname);

                if (r=="" && defaultToFieldname)
                    r=n;
                ret.addItem(r);
        	}
        }
        return ret;
	}
//
//
//    rem /**
//    rem * Method replaceFields:
//    rem * search and replace all the field names in a given string (formula) with the field value.
//    rem * The field name should be escaped as "F{name}".
//    rem * @param String formula: the string with the escaped field names
//    rem * @return String formula: the replaced string
//    rem */
	public String replaceFields(String Formula) throws Exception
	{
		

        Set<String> ks = this.FieldList.keySet();
        Iterator<String> it = ks.iterator();

        while (it.hasNext())
        {
            String k = it.next();
            String k1 = "$F{"+k+"}";

            Formula = Formula.replace(k1, this.getFieldAsString(k));
        }

		return Formula;
	}

	public Boolean equals(DataRow r) throws Exception
	{
		Boolean eq=true;
		BBjVector fields = r.getFieldNames();

        if (fields.size() != this.FieldList.size()) 
            eq=false;
        else
        {
        	@SuppressWarnings("unchecked")
			Iterator<String> it = fields.iterator();
        	while (it.hasNext())
        	{
        		String fieldname = it.next();
        		DataField f = this.FieldList.get(fieldname);
        		if (f==null || !r.getFieldAsString(fieldname).equals(this.getFieldAsString(fieldname)))
        		{
        			eq = false;
        			break;
        		}
        	}
        }
        return eq;
	}

	public void addDataField(String name, DataField field)
	{
	  this.FieldList.put(name,field);
	  this.FieldNames.add(name);
	}

	public DataRow clone()
	{
			
		DataRow dRow = new DataRow();
	
	    Set<String> ks = this.FieldList.keySet();
	    Iterator<String> it = ks.iterator();
	
	    
	    while (it.hasNext())
	    {
			String k = it.next();
			DataField f = this.FieldList.get(k);
			DataField f1 = f.clone();
			dRow.addDataField(k,f1);
	    }
	
	      return dRow;
	}

	public String getInsertStatement()
	{

        Set<String> ks = this.FieldList.keySet();
        Iterator<String> it = ks.iterator();
        String f1="";
        String v="";
        String sql;
        while (it.hasNext())
        {
            String k = it.next();
            DataField f = this.FieldList.get(k);
            if (f.isNull())
                continue;
            f1=f1+","+k;
            v=v+","+f.getValueForSQL();
        }

        sql="(" +f1.substring(1)+ ") VALUES ("+v.substring(1)+")";

        return sql;

	}
	
	public String getUpdateStatement()
	{

        Set<String> ks = this.FieldList.keySet();
        Iterator<String> it = ks.iterator();

        String sql="";
        while (it.hasNext())
        {
            String k = it.next();
            DataField f = this.FieldList.get(k);
            if (f.isNull())
                continue;

            sql=sql+", "+k+"="+f.getValueForSQL();
        }

        if ( sql.length()>0 )
        	sql=sql.substring(1);

        return sql;
	}	

	public java.util.HashMap<String,Object> getObjects()
	{
		


        HashMap<String,Object> hm = new HashMap<String, Object>();

        Set<String> ks = this.FieldList.keySet();
        Iterator<String> it = ks.iterator();

        while (it.hasNext())
        {
            String k = it.next();
            DataField f = this.FieldList.get(k);

            if ( f.isNull() )
                continue;

            hm.put(k,f.getObject());
        }

        return hm;

	}

	public void setSQLType(String name, int SQLType) throws Exception
	{
		DataField field=this.FieldList.get(name);

		if (field == null) 
          	throw new Exception("Field "+name+" does not exist");

		field.setSQLType(SQLType);		
		
	}	
	
}