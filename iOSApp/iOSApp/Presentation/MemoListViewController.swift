//
//  MemoListViewController1.swift
//  iOSApp
//
//  Created by NAVER on 06/12/2018.
//  Copyright © 2018 myungpyo. All rights reserved.
//

import UIKit
import SharedCode

class MemoListViewController: BaseUIViewController {
    
    
    var viewModel : MemoListViewModel?
    
    var memos = [Memo]()
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.tableView.register(UITableViewCell.self, forCellReuseIdentifier: "reuseIdentifier")
        
        viewModel?.observeMemos()
            .subscribe(onNext: { memos in
                self.memos.append(contentsOf: memos)
                self.tableView.reloadData()
            })
            .disposed(by: disposeBag)
        
        viewModel?.syncMemos()

    }

    // MARK: - Table view data source


    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.memos.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "reuseIdentifier", for: indexPath)
 
        cell.textLabel?.text = self.memos[indexPath.row].description
        cell.textLabel?.numberOfLines = 0
        cell.textLabel?.sizeToFit()

        return cell
    }



}
