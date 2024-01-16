/**
 * 
 */
package beans;

import java.io.Serializable;

/**
 * JavaBeans
 * 1. クラスをpublic指定
 * 2. 引数なしのコンストラクタが定義
 * 3. java.io.Serializableを実装
 * 4. パッケージ化
 * 5. setter/getterを定義
 */
public class SubjectBean implements Serializable{
	private int subjectId;
	private String subjectName;
	private int delFlg;
	
	//引数なしコンストラクタ
	public SubjectBean() {
	}
	public SubjectBean(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(int delFlg) {
		this.delFlg = delFlg;
	}
	
	
	

}
