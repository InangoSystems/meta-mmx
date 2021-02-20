<!--
CONTRIBUTING.md

Copyright (c) 2013-2021 Inango Systems LTD.

Author: Inango Systems LTD. <support@inango-systems.com>
Creation Date: 20 Feb 2021

The author may be reached at support@inango-systems.com

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice,
this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
this list of conditions and the following disclaimer in the documentation
and/or other materials provided with the distribution.

Subject to the terms and conditions of this license, each copyright holder
and contributor hereby grants to those receiving rights under this license
a perpetual, worldwide, non-exclusive, no-charge, royalty-free, irrevocable
(except for failure to satisfy the conditions of this license) patent license
to make, have made, use, offer to sell, sell, import, and otherwise transfer
this software, where such license applies only to those patent claims, already
acquired or hereafter acquired, licensable by such copyright holder or contributor
that are necessarily infringed by:

(a) their Contribution(s) (the licensed copyrights of copyright holders and
non-copyrightable additions of contributors, in source or binary form) alone;
or

(b) combination of their Contribution(s) with the work of authorship to which
such Contribution(s) was added by such copyright holder or contributor, if,
at the time the Contribution is added, such addition causes such combination
to be necessarily infringed. The patent license shall not apply to any other
combinations which include the Contribution.

Except as expressly stated above, no rights or licenses from any copyright
holder or contributor is granted under this license, whether expressly, by
implication, estoppel or otherwise.

DISCLAIMER

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

NOTE

This is part of a management middleware software package called MMX that was developed by Inango Systems Ltd.

This version of MMX provides web and command-line management interfaces.

Please contact us at Inango at support@inango-systems.com if you would like to hear more about
- other management packages, such as SNMP, TR-069 or Netconf
- how we can extend the data model to support all parts of your system
- professional sub-contract and customization services
-->

# Contributing to MMX

You can contribute to MMX in various ways:
* reporting bugs
* improving documentation or code

## Reporting bugs

To report a bug - open issue via GitHub WebUI with label "bug"

## Contributing code

Before development is started - create an issue:
* with label "bug" for bugs
* with label "enhancement" for task
* with label "documentation" for docs improvements

All development is managed using GitHub Merge Requests

[Commits](#commits) must be in logical, consistent units and have a good commit message.
Every commit must carry a Signed-off-by tag to assert your agreement with the [DCO](#developers-certificate-of-origin).
Merge requests are reviewed and checks are performed on them before they are merged.
Code should adhere to the [coding style](#coding-style).

### Commits

The code history is considered a very important aspect of the source code of the project.
Please pay attention on the commits comment and content.

Commits should be split up into atomic units that perform one specific change.

A commit message consists of a subject, a message body and a set of tags.

    short title of commit

    The current situation is this and that. However, it should be that or
    that.

    We can do one or the other. One has this advantage, the other has this
    advantage. We choose one.

    Do this thing and do that thing 

    Signed-off-by: The Author <author.mail@address.com>
    Co-Authored-by: The Other Author <email@address.com>
    Signed-off-by: The Other Author <email@address.com>

Write it in the imperative: "add support for X"
Avoid verbs that don't say anything: "fix", "improve", "update", ...

At the end of the commit message there is a block of tags.

The first tag must be a "Signed-off-by:" from the author of the commit.
This is a short way for you to say that you are entitled to contribute the patch under MMX's BSD+Patent license.
It is a legal statement that asserts your agreement with the [DCO](#developers-certificate-of-origin).
Therefore, it must have your *real name* (First Last) and a valid e-mail address.
Adding this tag can be done automatically by using `git commit -s`.
If you are editing files and committing through GitHub, you must write your real name in the “Full Name” field in your GitHub profile and the email used in the "Signed-off-by:" must be your "Commit email" address.
You must manually add the "Signed-off-by:" to the commit message that GitHub requests.
If you are editing files and committing on your local PC, set your name and email with:

```bash
git config --global user.name "my name"
git config --global user.email "my@email.address"
```

Then, adding the "Signed-off-by" line is as simple as using `git commit -s` instead of `git commit` (using an alias is recommended, e.g. `git config --global alias.ci='commit -s'`)

<a id="coding-style"></a>
### Coding style

TBD

Note: write a new code in the same style as exist one.

<a id="developers-certificate-of-origin"></a>
## Developer's Certificate of Origin 1.1

By making a contribution to this project, I certify that:

* (a) The contribution was created in whole or in part by me and I
  have the right to submit it under the open source license
  indicated in the file; or

* (b) The contribution is based upon previous work that, to the best
  of my knowledge, is covered under an appropriate open source
  license and I have the right under that license to submit that
  work with modifications, whether created in whole or in part
  by me, under the same open source license (unless I am
  permitted to submit under a different license), as indicated
  in the file; or

* (c) The contribution was provided directly to me by some other
  person who certified (a), (b) or (c) and I have not modified
  it.

* (d) I understand and agree that this project and the contribution
  are public and that a record of the contribution (including all
  personal information I submit with it, including my sign-off) is
  maintained indefinitely and may be redistributed consistent with
  this project or the open source license(s) involved.


